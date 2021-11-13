namespace Sample9
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void tm_Tick(object sender, EventArgs e)
        {
            DateTime dt = DateTime.Now;

            lb.Text = dt.ToLongTimeString();
        }
    }
}
