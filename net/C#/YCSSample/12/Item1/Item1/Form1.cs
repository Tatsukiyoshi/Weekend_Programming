using System.Collections;

namespace Item1
{
    public partial class Form1 : Form
    {

    public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            var ProductTable = new []
            {
                new {name="鉛筆", price=80},
                new {name="消しゴム", price=50},
                new {name="定規", price=200},
                new {name="コンパス", price=300},
                new {name="ボールペン", price=100}
            };

            IEnumerable qry = from K in ProductTable
                              select K;

            foreach(var tmp in qry)
            {
                lbx.Items.Add(tmp);
            }
       }
    }
}