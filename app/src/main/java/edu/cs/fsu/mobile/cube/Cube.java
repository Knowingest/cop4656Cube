//hmh16c
//Harrison Hill
//cop3252 game project
//7/30/2018

//This file houses the cube

//the stickers, what color they are, how you can move it, etc


//NOTATION

/* SIDES:
(U)p
(D)own

(R)ight
(L)eft

(F)ront
(B)ack
*/

//stickers are laid out like a numpad on a keyboard:
//789
//456
//123

//assuming you are looking directly at the side in question.
//IE, turning the cube 180 degrees would show that the (B)ack side 
//has the same layout as the (F)ront side

//The orientation is mostly standard except for the (D)own side.
//here, just assume we did an X rotation, and you're looking at the side head on.
//then it is laid out like a numpad as usual.

//there is probably a way to simplify this code, but since each side of the cube needs
//to be modified in a slightly different way, I did it all by hand.

import java.util.Random;

class Cube
    {

        public char[] r = new char[10];     //these are the colors
        public char[] l = new char[10];
        public char[] u = new char[10];
        public char[] d = new char[10];
        public char[] f = new char[10];
        public char[] b = new char[10];

        public void reset()
        {
            for (int i = 1; i < 10; i++)
                u[i] = 'y';
            for (int i = 1; i < 10; i++)
                d[i] = 'w';
            for (int i = 1; i < 10; i++)
                f[i] = 'b';
            for (int i = 1; i < 10; i++)
                b[i] = 'g';
            for (int i = 1; i < 10; i++)
                r[i] = 'r';
            for (int i = 1; i < 10; i++)
                l[i] = 'o';
        }

        public void scramble()  //randomly does 30 moves
        {
            int max = 6;
            for (int i = 0; i < 30; i++)
            {
                int r = 0 + (int)(Math.random() * 5);
                if (r == 0) u();
                else if (r == 1) d();
                else if (r == 2) r();
                else if (r == 3) l();
                else if (r == 4) f();
                else if (r == 5) b();
            }
        }

            //checks if all sides have all the same color sticker
                //it doesn't check for any particular color on any face, since the cube could be rotated
                // (the 'u' face might not always be yellow, etc etc)
                //however, there is only one possible way of having all sides with solid colors, so we just check for that.
        public boolean checkIfSolved()
        {
            char ut = u[1];
            for (int i = 1; i < 10; i++)
            {
                if(u[i] != ut) return false; 
            }
            char dt = d[1];
            for (int i = 1; i < 10; i++)
            {
                if(d[i] != dt) return false; 
            }
            char rt = r[1];
            for (int i = 1; i < 10; i++)
            {
                if(r[i] != rt) return false; 
            }
            char lt = l[1];
            for (int i = 1; i < 10; i++)
            {
                if(l[i] != lt) return false; 
            }
            char ft = f[1];
            for (int i = 1; i < 10; i++)
            {
                if(f[i] != ft) return false; 
            }
            char bt = b[1];
            for (int i = 1; i < 10; i++)
            {
                if(b[i] != bt) return false; 
            }
            return true;
        }

        public Cube()
        {reset();}

        public void print() //used for testing before the UI was done
        {
            System.out.println("Front:");
            System.out.printf("%c %c %c\n", f[7], f[8], f[9]);
            System.out.printf("%c %c %c\n", f[4], f[5], f[6]);
            System.out.printf("%c %c %c\n", f[1], f[2], f[3]);
            
            System.out.println("\nBack:");
            System.out.printf("%c %c %c\n", b[7], b[8], b[9]);
            System.out.printf("%c %c %c\n", b[4], b[5], b[6]);
            System.out.printf("%c %c %c\n", b[1], b[2], b[3]);
            
            System.out.println("\nRight:");
            System.out.printf("%c %c %c\n", r[7], r[8], r[9]);
            System.out.printf("%c %c %c\n", r[4], r[5], r[6]);
            System.out.printf("%c %c %c\n", r[1], r[2], r[3]);
            
            System.out.println("\nLeft:");
            System.out.printf("%c %c %c\n", l[7], l[8], l[9]);
            System.out.printf("%c %c %c\n", l[4], l[5], l[6]);
            System.out.printf("%c %c %c\n", l[1], l[2], l[3]);
            
            System.out.println("\nUp:");
            System.out.printf("%c %c %c\n", u[7], u[8], u[9]);
            System.out.printf("%c %c %c\n", u[4], u[5], u[6]);
            System.out.printf("%c %c %c\n", u[1], u[2], u[3]);
            
            System.out.println("\nDown:");
            System.out.printf("%c %c %c\n", d[7], d[8], d[9]);
            System.out.printf("%c %c %c\n", d[4], d[5], d[6]);
            System.out.printf("%c %c %c\n", d[1], d[2], d[3]);
        }

        public void swap(char[] f1, char[] f2, int x, int y)    //unused?
        {
            char c = f1[x];
            f1[x] = f2[y];
            f2[y] = c;
        }

        //rotates single face
        //NOTE, this only is used by the other functions, never called on its own
        //  it only does part of the work.  the other functions complete the job.
        //  this function is meaningless on its own
        public void rotate_face(char[] c)
        {
            //edges first
            char temp = c[6];
            c[6] = c[8];
            c[8] = c[4];
            c[4] = c[2];
            c[2] = temp;

            //now corners
            temp = c[9];
            c[9] = c[7];
            c[7] = c[1];
            c[1] = c[3];
            c[3] = temp;
        }

        //these functions are how we turn faces of the cube

        //if the naming convention confuses you, read up on rubik's cube notation.
        //these names are all standardized, and quickly memorized by those who cube.

        //I will not attempt to explain it here.  visual guides can be found online

        public void r()
        {
            char temp;
            rotate_face(r);
            temp = f[9];
            f[9] = d[9];
            d[9] = b[1];
            b[1] = u[9];
            u[9] = temp;

            temp = f[6];
            f[6] = d[6];
            d[6] = b[4];
            b[4] = u[6];
            u[6] = temp;

            temp = f[3];
            f[3] = d[3];
            d[3] = b[7];
            b[7] = u[3];
            u[3] = temp;
        }

        public void l()
        {
            char temp;
            rotate_face(l);
            temp = f[7];
            f[7] = u[7];
            u[7] = b[3];
            b[3] = d[7];
            d[7] = temp;

            temp = f[4];
            f[4] = u[4];
            u[4] = b[6];
            b[6] = d[4];
            d[4] = temp;

            temp = f[1];
            f[1] = u[1];
            u[1] = b[9];
            b[9] = d[1];
            d[1] = temp;
        }

        public void u()
        {
            char temp;
            rotate_face(u);
            temp = f[9];
            f[9] = r[9];
            r[9] = b[9];
            b[9] = l[9];
            l[9] = temp;

            temp = f[8];
            f[8] = r[8];
            r[8] = b[8];
            b[8] = l[8];
            l[8] = temp;

            temp = f[7];
            f[7] = r[7];
            r[7] = b[7];
            b[7] = l[7];
            l[7] = temp;

        }

        public void d()
        {
            char temp;
            rotate_face(d);
            temp = f[1];
            f[1] = l[1];
            l[1] = b[1];
            b[1] = r[1];
            r[1] = temp;

            temp = f[2];
            f[2] = l[2];
            l[2] = b[2];
            b[2] = r[2];
            r[2] = temp;

            temp = f[3];
            f[3] = l[3];
            l[3] = b[3];
            b[3] = r[3];
            r[3] = temp;
        }

        public void f()
        {
            char temp;
            rotate_face(f);
            temp = u[3];
            u[3] = l[9];
            l[9] = d[7];
            d[7] = r[1];
            r[1] = temp;

            temp = u[2];
            u[2] = l[6];
            l[6] = d[8];
            d[8] = r[4];
            r[4] = temp;

            temp = u[1];
            u[1] = l[3];
            l[3] = d[9];
            d[9] = r[7];
            r[7] = temp;
        }

        public void b()
        {
            char temp;
            rotate_face(b);
            temp = u[9];
            u[9] = r[3];
            r[3] = d[1];
            d[1] = l[7];
            l[7] = temp;

            temp = u[8];
            u[8] = r[6];
            r[6] = d[2];
            d[2] = l[4];
            l[4] = temp;

            temp = u[7];
            u[7] = r[9];
            r[9] = d[3];
            d[3] = l[1];
            l[1] = temp;
        }

        public void ri()
        {r();r();r();}

        public void li()
        {l();l();l();}

        public void ui()
        {u();u();u();}

        public void di()
        {d();d();d();}

        public void fi()
        {f();f();f();}

        public void bi()
        {b();b();b();}

        public void m()
        {mi();mi();mi();}

        public void mi()
        {
            char temp = f[5];
            f[5] = d[5];
            d[5] = b[5];
            b[5] = u[5];
            u[5] = temp;

            temp = f[8];
            f[8] = d[8];
            d[8] = b[2];
            b[2] = u[8];
            u[8] = temp;

            temp = f[2];
            f[2] = d[2];
            d[2] = b[8];
            b[8] = u[2];
            u[2] = temp;
        }

        public void e()
        {
            char temp = f[6];
            f[6] = l[6];
            l[6] = b[6];
            b[6] = r[6];
            r[6] = temp;

            temp = f[5];
            f[5] = l[5];
            l[5] = b[5];
            b[5] = r[5];
            r[5] = temp;

            temp = f[4];
            f[4] = l[4];
            l[4] = b[4];
            b[4] = r[4];
            r[4] = temp;
        }

        public void ei()
        {e();e();e();}

        public void s()
        {
            char temp = u[6];
            u[6] = l[8];
            l[8] = d[4];
            d[4] = r[2];
            r[2] = temp;

            temp = u[5];
            u[5] = l[5];
            l[5] = d[5];
            d[5] = r[5];
            r[5] = temp;

            temp = u[4];
            u[4] = l[2];
            l[2] = d[6];
            d[6] = r[8];
            r[8] = temp;
        }

        public void si()
        {s();s();s();}

        public void x()
        {r();mi();li();}

        public void xi()
        {x();x();x();}

        public void y()
        {u();ei();di();}

        public void yi()
        {y();y();y();}

        public void z()
        {f();bi();s();}

        public void zi()
        {z();z();z();}


    }