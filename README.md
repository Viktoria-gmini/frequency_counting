������������ �� �������:
1. ���������, ��� � ��� ���������� Java Development Kit (JDK) ������ 17 ��� ����.
2. ���������, ��� � ����� ������� ��������� ��� ����������� ����������� �� ����� pom.xml.
3. ������������� � �������� ��� ������ � ������� Maven, ��������� ������� mvn clean package.


������ �������� ����������:

����� calculateFrequency ����������� ��������� ������ � ������� JSON � ��������� inputString. ������ JSON-������� ��� ������������:
{
  "inputString": "aaaaabbbc"
}


������ ��������� ����������:
����� calculateFrequency ���������� ��������� � ���� ���������������� ���� �������� � �� ������� � ������� JSON. ������ JSON-������:

{
  "a": 5,
  "b": 3,
  "c": 1
  // � ��� �����, � ����������� �� ������� ������
}
![img.png](img.png)

������ ��� ����� ����� Swagger
http://localhost:8082/swagger-ui.html#/frequency-controller