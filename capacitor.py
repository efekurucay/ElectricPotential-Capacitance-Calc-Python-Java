import tkinter as tk
from tkinter import ttk

# Kapasitans hesaplama fonksiyonu
def calculate_capacitance(area, separation, voltage):
    epsilon_0 = 8.854e-12  # Boşluğun elektriksel geçirgenliği (F/m)
    area_m2 = area * 1e-6  # mm^2'yi m^2'ye dönüştürme
    separation_m = separation * 1e-3  # mm'yi m'ye dönüştürme
    capacitance = (epsilon_0 * area_m2) / separation_m
    return capacitance * 1e12  # F'yi pF'ye dönüştürme

# Track bar değerlerinin değişiminde çağrılan fonksiyon
def update_values(event=None):
    area = area_scale.get()
    separation = separation_scale.get()
    voltage = voltage_scale.get()
    
    capacitance = calculate_capacitance(area, separation, voltage)
    charge = capacitance * voltage  # Q = C * V
    
    area_value_label.config(text=f"Plate Area: {area:.1f} mm²")
    separation_value_label.config(text=f"Separation: {separation:.1f} mm")
    voltage_value_label.config(text=f"Battery Voltage: {voltage:.1f} V")
    capacitance_label.config(text=f"Capacitance: {capacitance:.2f} pF")
    charge_label.config(text=f"Top Plate Charge: {charge:.2f} pC")

# Tkinter arayüzü
root = tk.Tk()
root.title("Capacitor Calculation")

# Track barlar
area_scale = tk.Scale(root, from_=100, to_=1000, resolution=0.1, orient="horizontal", command=update_values)
area_scale.set(100)
area_scale.pack()
area_value_label = tk.Label(root, text="Plate Area: 100.0 mm²")
area_value_label.pack()

separation_scale = tk.Scale(root, from_=1, to_=10, resolution=0.1, orient="horizontal", command=update_values)
separation_scale.set(2)
separation_scale.pack()
separation_value_label = tk.Label(root, text="Separation: 2.0 mm")
separation_value_label.pack()

voltage_scale = tk.Scale(root, from_=1, to_=10, resolution=0.1, orient="horizontal", command=update_values)
voltage_scale.set(1.5)
voltage_scale.pack()
voltage_value_label = tk.Label(root, text="Battery Voltage: 1.5 V")
voltage_value_label.pack()

# Kapasitans ve üst plaka yükü etiketleri
capacitance_label = tk.Label(root, text="Capacitance: ")
capacitance_label.pack()

charge_label = tk.Label(root, text="Top Plate Charge: ")
charge_label.pack()

# Başlangıç değerlerini güncelle
update_values()

# Arayüzü başlat
root.mainloop()
