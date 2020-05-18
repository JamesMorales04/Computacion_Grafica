using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Security.Cryptography;
using System.Threading;
using UnityEngine;

public class Vibrae : MonoBehaviour
{
    public float Duracion;
    public float Intencidad;
    
    public void shake(float duracion, float intencidad)
    {
        Duracion = duracion;
        Intencidad = intencidad;
        StartCoroutine("shake");
    }

    IEnumerator shake()
    {
        float TiempoTranscurrido = 0;
        Vector3 PosInicial = transform.position;
        while (TiempoTranscurrido < Duracion)
        {
            TiempoTranscurrido += Time.deltaTime;
            float PTT = TiempoTranscurrido / Duracion;
            float compuerta = 1 - Mathf.Clamp(PTT * 4 - 3, 0f, 1f);

            float x = UnityEngine.Random.Range(-1f, 1f) * compuerta * Intencidad;
            float y = UnityEngine.Random.Range(-1f, 1f) * compuerta * Intencidad;
            float z = UnityEngine.Random.Range(-1f, 1f) * compuerta * Intencidad;

            transform.position += new Vector3(x, y, z);
            yield return null;
        }
        transform.position = PosInicial;
    }
    void OnTriggerEnter()
    {
        shake(0.1f, .5f);
    }
}
