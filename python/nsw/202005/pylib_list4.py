import xml.etree.ElementTree as ET

tree = ET.parse('sample1.xml')
root = tree.getroot()

elm = ET.Element('country')
elm.set('name', 'フランス')
root.append(elm)

tree.write('output.xml',
    encoding='utf-8', xml_declaration=True)

