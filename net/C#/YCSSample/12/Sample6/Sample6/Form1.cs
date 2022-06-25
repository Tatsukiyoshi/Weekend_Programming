using System.Collections;
using System.Xml.Linq;

namespace Sample6
{
    public partial class Form1 : Form
    {
        String XMLPath = "..\\..\\..\\..\\..\\..\\data\\Sample.xml";

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            XDocument doc = XDocument.Load(XMLPath);

            IEnumerable qry = from K in doc.Descendants("car")
                              where (int?)K.Attribute("id") >= 1005
                              select K.Element("name")?.Value;

            foreach (var tmp in qry)
            {
                lbx.Items.Add(tmp);
            }
        }
    }
}