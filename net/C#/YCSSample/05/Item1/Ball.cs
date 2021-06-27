using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Item1
{
    class Ball
    {
        private int top;
        private int left;

        public Ball()
        {
            top = 0;
            left = 0;
        }

        public int Top
        {
            set { top = value; }
            get { return top; }
        }

        public int Left
        {
            set { left = value; }
            get { return left; }
        }

        public void Move()
        {
            top += 10;
            left += 10;
        }
    }
}
