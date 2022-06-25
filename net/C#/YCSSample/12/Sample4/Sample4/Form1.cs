using System.Collections;
using System.Linq;
using System.Xml.Linq;

namespace Sample4
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            XDocument doc = XDocument.Load("..\\..\\..\\..\\..\\..\\data\\Sample.xml");
            IEnumerable qry = from K in doc.Descendants("car")
                              select K;

            foreach (var tmp in qry)
            {
                lbx.Items.Add(tmp);
            }
        }
    }
}
