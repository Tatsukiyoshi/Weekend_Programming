using System.Collections;
using System.Xml.Linq;

namespace Sample5
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
                              where (string?)K.Attribute("country") == "“ú–{"
                              select K;

            foreach(var tmp in qry)
            {
                lbx.Items.Add(tmp);
            }
        }
    }
}
