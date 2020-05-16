

#include "colors.inc"



#declare Camera_0 = camera {angle 70
                            location  <0.0 , 1.0 ,-2.0>
                            right     x*image_width/image_height
                            look_at   <0.0 , 0.2 , 0.0>}
camera{Camera_0}     


light_source{<-1500,2500,-2500> color White}

plane {
    y, -2
    pigment {checker Pink, White}
}
sphere {
    <0.1 , 0.5 ,-0.8>, 0.1
    pigment { Red }
    finish {
      ambient 0.1
      diffuse 1
      phong 0.1
      phong_size 10
     }

}

sphere {
    <-0.5 , 0.5 ,-0.5>, 0.1
    pigment { Green }
    finish {
          ambient 1
          diffuse 1
          phong .8
          phong_size 60
        }
    
}

 sphere {
    <0.5 , 0.8 ,-0.5>, 0.1
    pigment { Blue }
    finish {
        ambient 0
        diffuse 0.5
        phong 1
        phong_size 100
        }
    
}

#declare Chessboard = 
union{
box { <-1.01, 0.00, -1.01>,< 1.01, 0.049, 1.01>   
      texture{ pigment{ color rgb< 0.75, 0.5, 0.30>*0.5 }   
             }
    }
box { <-1.00, 0.00, -1.00>,< 1.00, 0.05, 1.00>   
      texture{ pigment{ checker color rgb<1,1,1> color rgb<0,0,0> }   
               scale 0.25 
             }
    } 
} 


object{ Chessboard
        scale 1 
        rotate<-25,30,0> 
        translate<0.05,0.6,0> 
      }





