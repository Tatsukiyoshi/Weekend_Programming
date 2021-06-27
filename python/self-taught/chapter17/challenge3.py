# http://tinyurl.com/jmlkvxm

import re

text = "The ghost that says boo haunts the loo"

res = re.findall(".?oo", text)
print(res)
