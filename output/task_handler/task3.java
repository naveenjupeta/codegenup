import os
import sys
from py2java import convert_file

if len(sys.argv)!= 2:
    print("Usage: python convert_python_to_java.py <python_file>")
    sys.exit(1)

python_file = sys.argv[1]
java_file = os.path.splitext(python_file)[0] + ".java"

convert_file(python_file, java_file)
