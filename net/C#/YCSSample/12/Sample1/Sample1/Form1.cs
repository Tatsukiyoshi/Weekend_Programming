using System.Collections;

namespace Sample1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            var 車表 = new[]
            {
                new {番号 = 2, 名前 = "乗用車"},
                new {番号 = 3, 名前 = "オープンカー" },
                new {番号 = 4, 名前 = "トラック" },
            };

            IEnumerable qry = from K in 車表
                              select new { K.名前, K.番号 };

            foreach(var tmp in qry)
            {
                lbx.Items.Add(tmp);
            }
        }
    }
}