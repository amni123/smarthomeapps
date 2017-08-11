



/*
 *  This sketch sends data via HTTP GET requests to data.sparkfun.com service.
 *
 *  You need to get streamId and privateKey at data.sparkfun.com and paste them
 *  below. Or just customize this script to talk to other HTTP servers.
 *
 */

#include <ESP8266WiFi.h>

// Replace these with your WiFi network settings
const char* ssid     = "MyDD2017";
const char* password = "mydd@2017";//replace this with your WiFi network password

int pump = 4;

void setup()
{
  pinMode(pump, OUTPUT);
  
  delay(1000);
  
  Serial.begin(115200);
 
  WiFi.begin(ssid, password);
  
  Serial.println();
  Serial.print("Connecting");
  while (WiFi.status() != WL_CONNECTED)
  {
    delay(500);
    Serial.print(".");
  }

  Serial.println("success!");
  Serial.print("IP Address is: ");
  Serial.println(WiFi.localIP());
}

void loop() {
  int data = analogRead(A0);
  Serial.println(data);

  if (data > 500){
    digitalWrite(pump, LOW);
  }
  else{
    digitalWrite(pump, HIGH);
  }
}

