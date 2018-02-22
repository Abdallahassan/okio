# -*- coding: utf-8 -*-

# Copy this example and replace okio/covg.txt with okio/SomeNewFileName.txt, then replace the names inside file.write(...) with the names of your functions Branch IDs that you call in Java
# But they should always have FALSE after them, and you have to call this python script before each time you run mvn test.

file = open('okio/covg.txt','w') 

file.write('start FALSE\n') 
file.write('if_size FALSE\n') 
file.write('if_inner FALSE\n') 
file.write('else_size FALSE\n') 
file.write('else_inner FALSE\n') 

file.close() 

# END of example. Copy new functions after this line.
