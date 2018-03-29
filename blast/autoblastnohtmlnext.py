import Bio
from Bio.Blast.Applications import NcbiblastxCommandline
from Bio.Blast import NCBIWWW, NCBIXML
import pickle
import os
#from mod_python import apache
import stat
import time
import sys



def blast(titel,seq,typeBlast, matrix,dataBase):
	directory = "BlastResults"	
	if not os.path.exists(directory):
    		os.makedirs(directory)
	busy = True
	while busy:
		#try:
			blastje = NCBIWWW.qblast(program = typeBlast, database = dataBase, sequence = seq,word_size = 6, matrix_name= matrix)
			busy = False
		#except:
		#	print("Shit's broke")
		#	time.sleep(60)
	with open("%s/%s%s.xml"%(directory, titel, typeBlast),"w") as out_handle:
		out_handle.write(blastje.read())



blast(sys.argv[1],sys.argv[2],sys.argv[3],sys.argv[4],sys.argv[5])

