// See https://aka.ms/new-console-template for more information

// XML読み込み
using System.Xml;
using System.Xml.Linq;
using System.Configuration;

// 実施例として、LineFontを表示するWindowsフォームアプリのリソースを使用する。
// ファイルの場所は、本アプリの実行時カレントディレクトリから５階層上がC#プロジェクトのルートディレクトリなので、
// そのルートディレクトリ配下のLineFontsソリューションにあるResources.resxを読み込む。
// (C#)
//   + LineFonts
//     + LineFonts
//       + Properties
//         - Resource.resx
//   + ResourceAnalyze
//     + ResourceAnalyze
//       + bin
//         + Debug (or Release)
//           + net7.0 <- アプリの実行時カレントディレクトリ
// <data name="LINESeedJP_TTF_Bd" type="System.Resources.ResXFileRef, System.Windows.Forms">
//   <value>..\Fonts\LINESeedJP_TTF_Bd.ttf; System.Byte[], mscorlib, Version = 4.0.0.0, Culture = neutral, PublicKeyToken = b77a5c561934e089 </value>
// </data>
// <data name="LINESeedJP_TTF_Rg" type="System.Resources.ResXFileRef, System.Windows.Forms">
//   <value>..\Fonts\LINESeedJP_TTF_Rg.ttf; System.Byte[], mscorlib, Version = 4.0.0.0, Culture = neutral, PublicKeyToken = b77a5c561934e089 </ value >
// </data>

// XElement xml = XElement.Load(@"..\..\..\..\..\LineFonts\LineFonts\Properties\Resources.resx");
String? resourceFileName = ConfigurationManager.AppSettings["resourceFile"];

if (String.IsNullOrEmpty(resourceFileName))
{
    Console.WriteLine("resourceFileが設定されていません。");
}
else
{
    XElement xml = XElement.Load(resourceFileName);

    IEnumerable<XElement> resources = xml.Elements("data");

    foreach (XElement resource in resources)
    {
        Console.WriteLine("{0},{1},{2}", resource.Attribute("name"), resource.Attribute("type"), resource.Element("value"));
    }
}
