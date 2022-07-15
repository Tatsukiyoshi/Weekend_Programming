using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DrawApp
{
    internal class Rect : Shape
    {
        public override void Draw(Graphics g)
        {
            SolidBrush sb = new(color);
            g.FillRectangle(sb, x1, y1, x2 - x1, y2 - y1);
        }
    }
}
