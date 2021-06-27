import xml.etree.ElementTree as ET

tree = ET.parse('sample1.xml')
root = tree.getroot()

root.remove(root[1])

tree.write('output.xml',
    encoding='utf-8', xml_declaration=True)
