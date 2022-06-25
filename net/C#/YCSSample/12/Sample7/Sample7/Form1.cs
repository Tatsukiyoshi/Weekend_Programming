using System.Collections;
using System.Xml.Linq;

namespace Sample7
{
    public partial class Form1 : Form
    {
        readonly String XMLPath = "..\\..\\..\\..\\..\\..\\data\\Sample.xml";

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            XDocument doc = XDocument.Load(XMLPath);

            IEnumerable qry = from K in doc.Descendants("car")
                              orderby (int?)K.Attribute("id")
                              select K;

            foreach(var tmp in qry)
            {
                lbx.Items.Add(tmp);
            }
        }
    }
}
