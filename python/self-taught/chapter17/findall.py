# http://tinyurl.com/j399sq9

import re

t = "__one__ __two__ __three__"
found = re.findall("__.*?__", t)
for match in found:
    print(match)
