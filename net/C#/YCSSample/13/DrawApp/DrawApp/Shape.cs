using Microsoft.VisualBasic;
using System.Runtime.Serialization;

namespace DrawApp
{
    [KnownType(typeof(Shape))]
    [KnownType(typeof(Rect))]
    [KnownType(typeof(Oval))]
    [KnownType(typeof(Line))]
    [DataContract]
    abstract class Shape
    {
        public static int RECT = 0;
        public static int OVAL = 1;
        public static int LINE = 2;

        [DataMember]
        public int x1;
        [DataMember]
        public int y1;
        [DataMember]
        public int x2;
        [DataMember]
        public int y2;
        [DataMember]
        public Color color;

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
