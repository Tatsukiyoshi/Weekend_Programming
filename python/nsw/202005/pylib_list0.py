import xml.etree.ElementTree as ET

tree = ET.parse('sample1.xml')
root = tree.getroot()
ET.dump(root)
