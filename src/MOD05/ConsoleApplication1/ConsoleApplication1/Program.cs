using ConsoleApplication1.DuendeVerde;
using System;
using System.Dynamic;
using System.Linq;

namespace ConsoleApplication1
{
    class Program
    {
        string _var;

        static void Main(string[] args)
        {
            #region dynamic

            dynamic oi = new ExpandoObject();
            oi.Saudacao = "Hello!";
            oi.Saudacao += 10;

            Console.WriteLine(oi.Saudacao);

            #endregion

            #region array

            var nros = new[] { 1, 2, 3 }.ToList();
            nros.AddRange(new[] { 4, 5 });

            #endregion

            #region for

            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(i);
            }

            foreach (var i in nros)
            {
                Console.WriteLine(i);
            }

            Action<int> print = i => Console.WriteLine(i + " Bacon");
            nros.ForEach((print));
            new[] { 5, 6, 7 }.ToList().ForEach(print);
            new[] { 8, 9, 10 }.ToList().ForEach(print);

            #endregion

            #region Extensions Methods

            Console.WriteLine("Ana".ToBacon());

            #endregion

            #region Jedi

            var yoda = new Jedi
            {
                Nome = "Yoda",
                Grau = Grau.MESTRE
            };

            Console.WriteLine(yoda.Nome +" / "+ yoda.Grau);

            #endregion

            #region DateTime

            DateTime agora = DateTime.Now;
            DateTime amanha = agora.AddDays(1);

            Console.WriteLine(agora +" --- "+ amanha);

            #endregion

            Console.ReadLine();
        }
    }
}