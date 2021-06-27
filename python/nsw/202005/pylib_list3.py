import xml.etree.ElementTree as ET

tree = ET.parse('sample1.xml')
root = tree.getroot()

root[2].set('name', 'Panama')

tree.write('output.xml',
    encoding='utf-8', xml_declaration=True)
