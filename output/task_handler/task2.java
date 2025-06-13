def convert_python_to_java(python_file_path):
    java_file_path = python_file_path.replace('.py', '.java')
    with open(python_file_path, 'r') as python_file, open(java_file_path, 'w') as java_file:
        java_file.write('public class {class_name} {{\n'.format(class_name=python_file.name.capitalize()))
        for line in python_file:
            if line.startswith('def '):
                java_file.write('    public static {return_type} {function_name}({arguments}) {{\n'.format(
                    return_type=line.split('def ')[1].split('(')[0],
                    function_name=line.split('(')[0].split('def ')[1],
                    arguments=line.split('(')[1].split(')')[0]
                ))
            else:
                java_file.write('       '+ line)
        java_file.write('    }\n}')