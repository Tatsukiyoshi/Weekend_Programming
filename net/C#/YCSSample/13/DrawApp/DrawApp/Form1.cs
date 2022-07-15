using System.Runtime.Serialization;
using System;
using System.Runtime.Serialization.Formatters.Binary;
using System.Xml;

namespace DrawApp
{
    public partial class DrawApp : Form
    {
        private List<Shape>? shapeList;
        private int currentShape;
        private Color currentColor;

        public DrawApp()
        {
            InitializeComponent();

            shapeList = new List<Shape>();
            currentShape = Shape.RECT;
            currentColor = Color.Blue;
        }

        private void MiOpen_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog = new()
            {
                Filter = "グラフィックファイル | *.g"
            };

            if (openFileDialog.ShowDialog() == DialogResult.OK)
            {
                FileStream fs = new(openFileDialog.FileName, FileMode.Open, FileAccess.Read);

                shapeList?.Clear();

                XmlDictionaryReader reader = XmlDictionaryReader.CreateTextReader(fs, new XmlDictionaryReaderQuotas());
                DataContractSerializer ser = new(typeof(List<Shape>));

                // Deserialize the data and read it from the instance.
                shapeList = (List<Shape>?)ser.ReadObject(reader, true);
                reader.Close();

                fs.Close();
                this.Invalidate();
            }
        }

        private void MiSave_Click(object sender, EventArgs e)
        {
            SaveFileDialog saveFileDialog = new()
            {
                Filter = "グラフィックファイル | *.g"
            };

            if(saveFileDialog.ShowDialog() == DialogResult.OK)
            {
                FileStream fs = new(saveFileDialog.FileName, FileMode.OpenOrCreate, FileAccess.Write);
                DataContractSerializer ser = new(typeof(List<Shape>));
                ser.WriteObject(fs, shapeList);
                fs.Close();
            }
        }

        private void MiPreview_Click(object sender, EventArgs e)
        {
            PrintPreviewDialog printPreviewDialog = new()
            {
                Document = pd
            };
            printPreviewDialog.ShowDialog();
        }

        private void MiPrint_Click(object sender, EventArgs e)
        {
            pd.Print();
        }

        private void MiRectangle_Click(object sender, EventArgs e)
        {
            currentShape = Shape.RECT;
        }

        private void MiOval_Click(object sender, EventArgs e)
        {
            currentShape = Shape.OVAL;
        }

        private void MiLine_Click(object sender, EventArgs e)
        {
            currentShape = Shape.LINE;
        }

        private void MiColor_Click(object sender, EventArgs e)
        {
            ColorDialog colorDialog = new();

            if(colorDialog.ShowDialog() == DialogResult.OK)
            {
                currentColor = colorDialog.Color;
            }
        }

        private void DrawApp_MouseDown(object sender, MouseEventArgs e)
        {
            // 図形オブジェクトを作成する
            Shape sh;

            if(currentShape == Shape.RECT)
            {
                sh = new Rect();
            }
            else if(currentShape == Shape.OVAL)
            {
                sh = new Oval();
            } 
            else
            {
                sh = new Line();
            }

            // 図形オブジェクトの色を設定する
            sh.SetColor(currentColor);

            // 図形オブジェクトの座標を設定する
            sh.SetStartPoint(e.X, e.Y);
            sh.SetEndPoint(e.X, e.Y);

            // 図形オブジェクトをリスト末尾に追加する
            shapeList?.Add(sh);
        }

        private void DrawApp_MouseUp(object sender, MouseEventArgs e)
        {
            // 図形オブジェクトをリスト末尾から取り出す
            Shape sh = shapeList?[shapeList.Count - 1];

            sh.SetEndPoint(e.X, e.Y);

            // フォームを再描画する
            this.Invalidate();
        }

        private void DrawApp_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;

            foreach(Shape sh in shapeList)
            {
                sh.Draw(g);
            }
        }

        private void pd_PrintPage(object sender, System.Drawing.Printing.PrintPageEventArgs e)
        {
            Graphics graphics = e.Graphics;

            foreach(Shape sh in shapeList)
            {
                sh.Draw(graphics);
            }
        }
    }
}
