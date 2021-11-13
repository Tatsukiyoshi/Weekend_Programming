namespace Sample6
{
    class Ball
    {
        public Color color;
        public Point point;
    }

    public partial class Form1 : Form
    {
        private List<Ball> listBall;

        public Form1()
        {
            InitializeComponent();

            this.Paint += new PaintEventHandler(fm_Paint);

            listBall = new List<Ball>();

            Random rn = new Random();

            for(int i=0; i < 30; i++)
            {
                Ball bl = new Ball();

                int x = rn.Next(this.Width);
                int y = rn.Next(this.Height);

                int r = rn.Next(256);
                int g = rn.Next(256);
                int b = rn.Next(256);

                Point p = new Point(x, y);
                Color c = Color.FromArgb(r, g, b);

                bl.point = p;
                bl.color = c;

                listBall.Add(bl);
            }
        }

        private void fm_Paint(object? sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            foreach(Ball bl in listBall)
            {
                Point p = bl.point;
                Color c = bl.color;
                SolidBrush br = new SolidBrush(c);

                g.FillEllipse(br, p.X, p.Y, 10, 10);
            }
        }
    }
}
