<!-- HTML dosyanızdaki tarih seçme alanı -->
<div class="mb-3">
    <label for="appointmentDate" class="form-label text-center">Randevu Tarihi</label>
    <input type="date" class="form-control" id="appointmentDate" name="appointmentDate" required>
</div>

<script>
// JavaScript ile tarih seçimini kontrol etme
document.addEventListener("DOMContentLoaded", function() {
    var availableDates = ["2023-12-20", "2023-12-21", "2023-12-22"]; // Kuaförün uygun olduğu tarihler

    var appointmentDateInput = document.getElementById("appointmentDate");

    appointmentDateInput.addEventListener("input", function() {
        var selectedDate = new Date(appointmentDateInput.value);

        // Seçilen tarih uygunsa
        if (availableDates.includes(formatDate(selectedDate))) {
            // Burada gerekli işlemleri yapabilirsiniz.
            console.log("Seçilen tarih uygun.");
        } else {
            // Seçilen tarih uygun değilse
            alert("Bu tarih uygun değil. Lütfen başka bir tarih seçin.");
            appointmentDateInput.value = ""; // Tarihi temizle
        }
    });

    function formatDate(date) {
        var year = date.getFullYear();
        var month = String(date.getMonth() + 1).padStart(2, "0");
        var day = String(date.getDate()).padStart(2, "0");

        return year + "-" + month + "-" + day;
    }
});
</script>

background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        border: 1px solid #c7d6cd;
        box-shadow: 0 0 40px #c7d6cd;
        cursor: pointer;