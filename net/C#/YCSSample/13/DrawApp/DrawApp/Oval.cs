using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DrawApp
{
    [Serializable]
    internal class Oval : Shape
    {
        public override void Draw(Graphics g)
        {
            SolidBrush sb = new(color);
            g.FillEllipse(sb, x1, y1, x2 - x1, y2 - y1);
        }
    }
}
