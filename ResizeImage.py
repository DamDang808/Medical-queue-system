import cv2
img = cv2.imread('D:\\DSA_2023\\JFrame\\HospitalManagement\\src\\logo.png')
img = cv2.resize(img, (1000, 600))
img = cv2.imwrite('D:\\DSA_2023\\JFrame\\HospitalManagement\\src\\logo.jpg', img)