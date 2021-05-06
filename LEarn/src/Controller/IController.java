/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 * Sebuah interface yang berfungsi untuk mendeskripsikan suatu class adalah class controller
 * @author Anas
 */
public interface IController {

    /**
     * Method untuk menampilkan view / UI pada saat ini
     */
    public void Show();

    /**
     * Method untuk menyembunyikan view / UI pada saat ini
     */
    public void Hide();
}
