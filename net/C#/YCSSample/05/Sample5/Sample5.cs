using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Sample5
{
    public partial class Sample5 : Form
    {
        // リソース（イメージ）格納先：実行ファイルからの相対パス
        // .NET 5プロジェクトでは、実行ファイルがプロジェクトのbin/<構成>/<TargetFramework>配下に生成されるため、
        // 5階層上のディレクトリにあるdataから取得することにする
        // ※.NET 4.7までは、プロジェクトのbin/<構成>配下
        private const string strImagePath = "..\\..\\..\\..\\..\\data\\";

        public Sample5()
        {
            InitializeComponent();

            this.BackgroundImage = Image.FromFile(strImagePath + "car.bmp");
        }
    }
}
