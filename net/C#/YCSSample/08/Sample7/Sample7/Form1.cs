using Timer = System.Windows.Forms.Timer;

namespace Sample7
{
    public partial class Form1 : Form
    {
        private Ball bl;
        private int dx, dy;

        public Form1()
        {
            InitializeComponent();

            bl = new Ball();

            Point p = new Point(0, 0);
            Color c = Color.Blue;

            bl.point = p;
            bl.color = c;

            dx = 2;
            dy = 2;

            Timer tm = new Timer();
            tm.Interval = 10;
            tm.Start();

            this.Paint += new PaintEventHandler(fm_Paint);
            tm.Tick += new EventHandler(tm_Tick);
            
        }


        // タイマーイベント
        private void tm_Tick(object? sender, EventArgs e)
        {
            Point p = bl.point;

            // フォーム外へ移動した場合には、移動量を負にする
            if(p.X < 0 || p.X > this.ClientSize.Width - 10)
            {
                dx = -dx;
            }
            if(p.Y < 0 || p.Y > this.ClientSize.Height - 10)
            {
                dy = -dy;
            }

            p.X = p.X + dx;
            p.Y = p.Y + dy;

            bl.point = p;

            this.Invalidate();

        }

        private void fm_Paint(object? sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            Point p = bl.point;
            Color c = bl.color;
            SolidBrush br = new SolidBrush(c);

            g.FillEllipse(br, p.X, p.Y, 10, 10);
        }

    }

    class Ball
    {
        public Color color;
        public Point point;
    }

}