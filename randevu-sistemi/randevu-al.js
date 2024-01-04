function submitForm(event) {
    event.preventDefault();
  
    // Form verilerini al
    var fullName = document.getElementById("fullName").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var appointmentDate = document.getElementById("appointmentDate").value;
    var serviceType = document.getElementById("serviceType").value;
    var message = document.getElementById("message").value;
  
    // Form verilerini konsola yazdır (Gerçek uygulamada sunucuya gönderilecektir)
    console.log("Ad Soyad: " + fullName);
    console.log("E-posta Adresi: " + email);
    console.log("Telefon Numarası: " + phone);
    console.log("Randevu Tarihi: " + appointmentDate);
    console.log("Hizmet Türü: " + serviceType);
    console.log("Açıklama: " + message);
  
    
  }
  
  
  