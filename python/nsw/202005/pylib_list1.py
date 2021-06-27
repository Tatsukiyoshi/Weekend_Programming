import xml.etree.ElementTree as ET

tree = ET.parse('sample1.xml')
root = tree.getroot()

print(root.tag)
print(root[0][2].text)
print(root[2][3].attrib)
print(root[2][3].attrib.get('name'))

for elm in root.iterfind('.//*[@name]'):
    print(elm.attrib)

for elm in root.iterfind('.//neighbor[@name]'):
    print(elm.attrib)

for elm in root.iterfind('.//neighbor[@name="マレーシア"]'):
    print(elm.attrib.get('direction'))
