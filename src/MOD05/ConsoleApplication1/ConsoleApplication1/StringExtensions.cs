using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1.DuendeVerde
{
    internal static class StringExtensions
    {
        internal static string ToBacon(this string str, bool? upperCase = true)
        {
            return upperCase.HasValue && upperCase.Value ? str + " BACON!!!" : str + " bacon!!!";
        }
    }
}
