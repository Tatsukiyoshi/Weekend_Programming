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
            var �ԕ\ = new[]
            {
                new {�ԍ� = 2, ���O = "��p��"},
                new {�ԍ� = 3, ���O = "�I�[�v���J�[" },
                new {�ԍ� = 4, ���O = "�g���b�N" },
            };

            IEnumerable qry = from K in �ԕ\
                              select new { K.���O, K.�ԍ� };

            foreach(var tmp in qry)
            {
                lbx.Items.Add(tmp);
            }
        }
    }
}