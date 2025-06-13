import os

def convert_python_to_java(python_file_path):
    java_file_path = os.path.splitext(python_file_path)[0] + '.java'
    with open(python_file_path, 'r') as python_file, open(java_file_path, 'w') as java_file:
        java_file.write('public class'+ os.path.splitext(os.path.basename(python_file_path))[0] +'{\n')
        for line in python_file:
            java_file.write(line.replace('print', 'System.out.println').replace('def', 'public static void').replace('return','return').replace('if', 'if').replace('else', 'else').replace('while', 'while').replace('for', 'for'))