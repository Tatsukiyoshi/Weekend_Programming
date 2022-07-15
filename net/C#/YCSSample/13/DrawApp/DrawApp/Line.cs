using Microsoft.VisualBasic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace DrawApp
{
    [KnownType(typeof(Line))]
    [DataContract]
    class Line : Shape
    {
        public override void Draw(Graphics g)
        {
            SolidBrush sb = new(color);
            Pen pen = new(sb);
            g.DrawLine(pen, x1, y1, x2, y2);
        }
    }
}
