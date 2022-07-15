namespace DrawApp
{
    [Serializable]
    abstract class Shape
    {
        public static int RECT = 0;
        public static int OVAL = 1;
        public static int LINE = 2;

        protected int x1, y1, x2, y2;
        protected Color color;

        abstract public void Draw(Graphics g);

        public void SetColor(Color color)
        {
            this.color = color;
        }
        public void SetStartPoint(int x, int y)
        {
            x1 = x; y1 = y;
        }
        public void SetEndPoint(int x, int y)
        {
            x2 = x; y2 = y;
        }
    }
}
