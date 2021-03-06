// Im�genes tomadas de: http://planetpixelemporium.com/planets.html
#include "colors.inc"

 

sphere {
    <0, 0,0>, 2

 

   
    normal{
        bump_map{
            jpeg "marsbump1k.jpg"
            bump_size 20
            map_type 1
            interpolate 2
        }
        rotate 290*y
    }
   
   
    pigment{
                 image_map{ 
                         jpeg "mars_1k_color.jpg"
                         //png "earth.png"
                        map_type 1
                        interpolate 2
                 }
    // shrink to get Rows*Columns images into <0,0> to <1,1>
    //scale <1/Columns, 1/Rows, 1>
    //scale<1, 1, 1>

 

    // also try this rotation!
    rotate 290*y

 

    // use this translation together with "once" (in image_map above)
    //translate <.75, .5, 0>

 

    // wrap it around a sphere centered at <0,0,0>
    //warp { spherical } // "warp", not "wrap"!

 

     } 
     
     
     finish{
        ambient 0.2
        diffuse 0.6
        phong 0.8
        phong_size 128
    }
    
}

 

  
light_source {
    <10, 10, 0>
    color White
}

 

  
  
camera {
    location <0, 0, -5>
    look_at <0, 0, 0>    
}
 