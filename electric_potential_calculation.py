import numpy as np
import matplotlib.pyplot as plt

# Yük ve sabitler
student_id = 123456789  # Öğrenci numaranızı buraya girin
charge = (student_id % 10) * 1e-9  # nC cinsinden yük
epsilon_0 = 8.85e-12  # C^2/(N·m^2)

# Matris boyutu ve hücre uzunluğu
matrix_size = 10
cell_length = 0.1  # metre

# Potansiyel hesaplama fonksiyonu
def calculate_potential(q, x, y):
    r = np.sqrt(x**2 + y**2)
    if r == 0:
        return np.inf  # Sonsuz potansiyel
    return q / (4 * np.pi * epsilon_0 * r)

# Potansiyel matrisi
potential_matrix = np.zeros((matrix_size, matrix_size))
for i in range(matrix_size):
    for j in range(matrix_size):
        x = i * cell_length
        y = j * cell_length
        potential_matrix[i, j] = calculate_potential(charge, x, y)

# Grafikler
fig, axs = plt.subplots(2, 2, figsize=(15, 10))

# 2D potansiyel matrisi grafiği
cax = axs[0, 0].imshow(potential_matrix, cmap='hot', interpolation='nearest')
fig.colorbar(cax, ax=axs[0, 0], label='Potansiyel (V)')
axs[0, 0].set_title('Potansiyel Matrisi')
axs[0, 0].set_xlabel('X Konumu (m)')
axs[0, 0].set_ylabel('Y Konumu (m)')

# x yönünde potansiyel grafiği (i=[1, 9], j=0)
x_positions = np.arange(1, matrix_size) * cell_length
x_potentials = potential_matrix[1:, 0]
axs[0, 1].plot(x_positions, x_potentials, marker='o')
axs[0, 1].set_title('X Yönünde Potansiyel (j=0)')
axs[0, 1].set_xlabel('X Konumu (m)')
axs[0, 1].set_ylabel('Potansiyel (V)')
axs[0, 1].grid(True)

# Diyagonal yönde potansiyel grafiği (i;j =[1;1] to [9,9])
diagonal_positions = np.arange(1, matrix_size) * cell_length * np.sqrt(2)
diagonal_potentials = [potential_matrix[i, i] for i in range(1, matrix_size)]
axs[1, 0].plot(diagonal_positions, diagonal_potentials, marker='o')
axs[1, 0].set_title('Diyagonal Yönde Potansiyel')
axs[1, 0].set_xlabel('Diyagonal Konum (m)')
axs[1, 0].set_ylabel('Potansiyel (V)')
axs[1, 0].grid(True)

# Eşpotansiyel çizgileri
x = np.linspace(0, (matrix_size-1)*cell_length, matrix_size)
y = np.linspace(0, (matrix_size-1)*cell_length, matrix_size)
X, Y = np.meshgrid(x, y)
Z = potential_matrix
contour = axs[1, 1].contour(X, Y, Z, levels=20)
axs[1, 1].set_title('Eşpotansiyel Çizgileri')
axs[1, 1].set_xlabel('X Konumu (m)')
axs[1, 1].set_ylabel('Y Konumu (m)')
axs[1, 1].grid(True)
fig.colorbar(contour, ax=axs[1, 1], label='Potansiyel (V)')

plt.tight_layout()
plt.show()
