using System.Collections;

namespace Item2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            var ProductTable = new[]
{
                new {name="‰”•M", price=80},
                new {name="Á‚µƒSƒ€", price=50},
                new {name="’è‹K", price=200},
                new {name="ƒRƒ“ƒpƒX", price=300},
                new {name="ƒ{[ƒ‹ƒyƒ“", price=100}
            };

            IEnumerable qry = from K in ProductTable
                              where K.price >= 200
                              select K;

            foreach (var tmp in qry)
            {
                lbx.Items.Add(tmp);
            }
        }
    }
}