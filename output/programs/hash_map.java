import jython

def convert_python_to_java(python_file_path):
    with open(python_file_path, 'r') as python_file:
        python_code = python_file.read()
    java_code = jython.translate(python_code)