using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    internal enum Grau
    {
        [Description("Jovem Padawan")]
        PADAWAN,
        [Description("Cavaleiro")]
        CAVALEIRO,
        [Description("Mestre")]
        MESTRE
    }
}
