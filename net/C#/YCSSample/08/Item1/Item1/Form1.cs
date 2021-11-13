namespace Item1
{
    public partial class Form1 : Form
    {
        private int[] data = { 100, 30, 50, 60, 70 };

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            for(int i = 0; i < data.Length; i++)
            {
                SolidBrush br = new SolidBrush(Color.Blue);

                g.FillRectangle(br, new Rectangle(i * 30, 150 - data[i], 20, data[i]));
            }
        }
    }
}
