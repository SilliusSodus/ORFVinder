package database;

import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.parsers.*;
import javax.xml.soap.Node;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import sequentie.ORF;

public class DataUpload {

        /**Wordt gebruikt om de sequentie om te zetten naar een blob
     * input: sequentie als string
     * output is een blob
     */
    public static Blob makeBlob(String seq) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ORFVinder", "owe7_pg5", "blaat1234");
        byte[] byteData = seq.getBytes("UTF-8");//Better to specify encoding
        Blob blobData = con.createBlob();
        return blobData;
    }
    
        /**Wordt gebruikt om de XML te lezen en de data in de database te zetten
     * input zijn het xml bestand en de sequentie als string
     * geen output
     */
    public static void xml_Reader(File xml, String seq) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, ClassNotFoundException, SQLException {
        File inputFile = xml;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        XPath xPath = XPathFactory.newInstance().newXPath();
        String type = "";
        String expressionBT = "/BlastOutput";
        NodeList nodeListBT = (NodeList) xPath.compile(expressionBT).evaluate(doc, XPathConstants.NODESET);

        org.w3c.dom.Node nNodeBT = nodeListBT.item(0);
        if (nNodeBT.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNodeBT;
            type = eElement.getElementsByTagName("BlastOutput_program").item(0).getTextContent();

        }

        DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        Calendar calobj = Calendar.getInstance();
        String datum = df.format(calobj.getTime());

        String blast = type + "," + datum + "," + seq;
        insertQueryBuilder("blast", blast);

        String expression = "/BlastOutput/BlastOutput_iterations/Iteration/Iteration_hits/Hit";
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
        for (int i = 0; i < 10; i++) {
            org.w3c.dom.Node nNode = nodeList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String hitDef = eElement.getElementsByTagName("Hit_def").item(0).getTextContent();
                String accessieCode = eElement.getElementsByTagName("Hit_accession").item(0).getTextContent();
                String eWaarde = eElement.getElementsByTagName("Hsp_evalue").item(0).getTextContent();
                Double score = Double.parseDouble(eElement.getElementsByTagName("Hsp_score").item(0).getTextContent());
                int coverage = 100 * eElement.getElementsByTagName("Hsp_hseq").item(0).getTextContent().length() / eElement.getElementsByTagName("Hsp_qseq").item(0).getTextContent().length();
                blast = type + "," + datum + "," + hitDef + "," + accessieCode + "," + eWaarde + "," + score + "," + coverage;
                insertQueryBuilder("blastresult", blast);
            }
        }

    }
    
    /**Om het values deel van de query te maken wordt een aantal placeholders (?) geplaatst.
     * input zijn de tabel in kwestie
     * output is het value deel van de insert query
     */
    public static String values(String tabel) {
        String values = "";
        if (null != tabel) {
            switch (tabel) {
                case "blast":
                    values = "values(?,?,?,?)";
                    break;
                case "orf":
                    values = "values(?,?,?)";
                    break;
                case "blastresult":
                    values = "values(?,?,?,?,?.?)";
                    break;
                case "sequentie":
                    values = "values(?,?)";
                    break;
            }
        }
        return values;
    }
    
    /**Wordt gebruikt om de insert querys te maken en uitvoeren
     * input zijn de tabel waar iets in moet komen en de waardes in een string geshceiden door een komma
     * geen output
     */
    public static void insertQueryBuilder(String tabel, String ruwe_values) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ORFVinder mooie DB", "owe7_pg5", "blaat1234");
        String values = values(tabel);
        PreparedStatement pst = con.prepareStatement("insert into " + tabel + " " + values + "");
        String[] valueslijst = ruwe_values.split(",");

        if (null != tabel) {
            switch (tabel) {
                case "blast": {
                    int iDBlast = getID(tabel, ruwe_values);
                    int iDSeq = getID("sequentie", valueslijst[2]);
                    pst.setString(1, valueslijst[0]);
                    pst.setString(2, valueslijst[1]);
                    pst.setInt(3, iDBlast);
                    pst.setInt(4, iDSeq);
                    break;
                }
                case "blastresult": {
                    int iDBlast = getID("blast", ruwe_values);
                    pst.setDouble(1, Double.parseDouble(valueslijst[4]));
                    pst.setInt(2, Integer.getInteger(valueslijst[5]));
                    pst.setString(3, valueslijst[2]);
                    pst.setString(4, valueslijst[3]);
                    pst.setInt(5, iDBlast);
                    pst.setDouble(6, Double.parseDouble(valueslijst[6]));
                    break;
                }
                case "orf": {
                    int iDOrf = getID("orf", valueslijst[0]);
                    pst.setInt(1, Integer.getInteger(valueslijst[0]));
                    pst.setInt(2, Integer.getInteger(valueslijst[1]));
                    pst.setInt(3, iDOrf);
                    break;
                }
                case "sequentie": {
                    Blob seqBlob = makeBlob(valueslijst[0]);
                    int iDSeq = getID("sequentie", valueslijst[0]);
                    pst.setBlob(1, seqBlob);
                    pst.setInt(2, iDSeq);
                    break;
                }
            }
        }

        pst.executeUpdate();
        con.close();
    }

    /**Wordt gebruikt om gegevens van een orf object op te vragen
     * input is het orf object
     * output is de locatie en de lengte van het orf smaen in een string gescheiden door een komma
     */
    private static String orf(sequentie.ORF orf) {
        int locatie = orf.getBegin();
        int eind = orf.getEnd();
        int lengte = eind - locatie;
        String orfString = locatie + "," + lengte;
        return orfString;
    }

    /**Wordt gebruikt om het unieke id van een entry in een tabel te bepalen
     * input zijn de betreffende tabel en de string waarmee moet worden vergeleken
     * output is het id van de btreffende entry
     */
    public static int getID(String tabel, String vergelijken) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/ORFVinder databank", "owe7_pg5", "blaat1234");
        Statement smt = con.createStatement();
        int iD = 0;
        ResultSet idSet = null;
        PreparedStatement pst = con.prepareStatement("select " + (tabel + "_ID") + " from" + tabel + " where " + tabel+ " = (?)");
        if ("sequentie".equals(tabel)) {
            Blob vergelijkBlob = makeBlob(vergelijken);
            pst.setBlob(1, vergelijkBlob);
            idSet = pst.executeQuery();
        }
        if ("blast".equals(tabel)) {
            String[] valueslijst = vergelijken.split(",");
            idSet = smt.executeQuery("SELECT " + (tabel + "_ID") + " FROM " + tabel + " WHERE type = '" + valueslijst[0] + "' AND datum  = '" + valueslijst[1] + "'");
        } else {
            pst.setString(1, vergelijken);
            idSet = pst.executeQuery();
        }
        while (idSet.next()) {
            iD = idSet.getInt((tabel + "_ID"));
        }

        if (iD == 0) {
            ResultSet resID = smt.executeQuery("SELECT COUNT (*) FROM " + tabel);
            while (resID.next()) {
                iD = resID.getInt(1);
                ++iD;
            }
        }

        con.close();
        return iD;

    }

    /**De main die alle andere methodes aanroept
     * input zijn het xml bestand ,een sequentie object en het coderingstype als string
     * geen output
     */
    public static void main(sequentie.Sequentie sequentieObject) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        insertQueryBuilder("sequentie", sequentieObject.getSequentie1());
        for (ArrayList<ORF> orfobjectlist : sequentieObject.getOrflijst()) {
            for (sequentie.ORF orfobject : orfobjectlist) {
                insertQueryBuilder("orf", orf(orfobject));
            }
        }
    }

}
