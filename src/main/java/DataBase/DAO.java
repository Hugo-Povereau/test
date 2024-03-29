package DataBase;

import DataStructure.ChiffreAff;
import DataStructure.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author sboyer-tech
 */
public class DAO 
{
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date;
    private final String admin="admin";
    private final DataSource myDataSource;
    
    public DAO(DataSource dataSource)
    {
        this.myDataSource = dataSource;
        this.date=new Date();
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Shared DAO methods. Click on the + sign on the left to edit the code.">
    
    /**
     * Utilisé dans la DAO uniquement.
     * @return le nombre de commandes.
     */
    private List<Integer> getAllOrderNumbers() throws DAOException   
    {
        List<Integer> NumOrders = new ArrayList();
        String sql = "Select ORDER_NUM FROM PURCHASE_ORDER";
        
        try (Connection connection = myDataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql))
        {
            try (ResultSet rs = stmt.executeQuery())
            {
                while(rs.next())
                {
                    NumOrders.add(rs.getInt("ORDER_NUM"));
                }
            }
            
        } catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return NumOrders;
    }
    
    /**
     * @param customerID    Id du client
     * @return Un client avec son nom,adresse, numero de telephone et son mail
     * @throws DataBase.DAOException 
     */
    public Client getClientData(int customerID) throws DAOException
    {
        Client cl=null;
        String sql = "SELECT NAME, ADDRESSLINE1, PHONE, EMAIL FROM CUSTOMER WHERE CUSTOMER_ID=?";
        String name, addr, tel, mail;
        
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1, customerID);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                name = rs.getString("NAME");
                addr=rs.getString("ADDRESSLINE1");
                tel=rs.getString("PHONE");
                mail=rs.getString("EMAIL");
                
                cl = new Client(name,addr,tel,mail);
            }
            
        } catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return cl;
    }
    
    /**
     * @return Tout les codes de remises.
     * @throws DataBase.DAOException */
    public List<Character> getDiscountCode() throws DAOException    
    {
        List<Character> dC = new ArrayList();
        
        String sql = "SELECT DISCOUNT_CODE FROM DISCOUNT_CODE";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                dC.add(rs.getString("DISCOUNT_CODE").charAt(0));
            }
            
        } catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return dC;
    }
    
    /**
     * @return Liste des companies de transport.
     * @throws DataBase.DAOException */
    public List<String> getFCompany() throws DAOException 
    {
        List<String> FC = new ArrayList();
        
        String sql = "SELECT DISTINCT FREIGHT_COMPANY FROM PURCHASE_ORDER";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                FC.add(rs.getString("FREIGHT_COMPANY"));
            }
            
        } catch(SQLException ex){
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return FC;
    }
    
    /**
     * @return Liste de nom de fabriquants.
     * @throws DataBase.DAOException */
    public List<String> getManufacturer() throws DAOException 
    {
        List<String> m = new ArrayList();
        
        String sql = "SELECT NAME FROM MANUFACTURER";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
        {
            while(rs.next())
            {
                m.add(rs.getString("NAME"));
            }
            
        } catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        return m;
    }
    
    /**
     * @param customerID 
     * @return Les commandes pour le client actuel.
     * @throws DataBase.DAOException */
    public List<Integer> getOrderNumbers(int customerID) throws DAOException //Returns a list of orders available for a customer. 
    {
        List<Integer> Orders = new ArrayList();
        
        String sql = "SELECT ORDER_NUM FROM PURCHASE_ORDER WHERE CUSTOMER_ID=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setObject(1, customerID);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Orders.add(rs.getInt("ORDER_NUM"));
            }
            
        } catch (SQLException ex)
        {
            throw new DAOException("DataBase Connection Failed.");
        }
        return Orders;
    }
    
    /**
     * @return Le nom des produits existant.
     * @throws DataBase.DAOException */
    public List<String> getProduct() throws DAOException 
    {
        List<String> P = new ArrayList();
        
        String sql = "SELECT DESCRIPTION FROM PRODUCT";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                P.add(rs.getString("DESCRIPTION"));
            }
            
        } catch(SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        return P;
    }
    
    /**
     * @return Liste des codes produit.
     * @throws DataBase.DAOException */
    public List<String> getProductCodes() throws DAOException 
    {
        List<String> pC = new ArrayList();
        
        String sql = "SELECT PROD_CODE FROM PRODUCT_CODE";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(admin))
        {
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                pC.add(rs.getString("PROD_CODE"));
            }
            
        } catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        return pC;
    }
    
    public List<String> getStates() throws DAOException //Returns all states currently populated by customers.
    {
        List<String> states = new ArrayList();
        
        String sql = "SELECT DISTINCT STATE FROM CUSTOMER";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
        {
            while(rs.next())
            {
                states.add(rs.getString("STATE"));
            }
            
        } catch (SQLException ex)
        {
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return states;
    }
    
    public boolean loginCheck(String Mail, String ID) throws DAOException   //Check if admin or Client.
    {        
        if(Mail==admin && ID==admin)
        {
            return true;
        }
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID=? and EMAIL=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1, ID);
            stmt.setString(2, Mail);
            ResultSet rs = stmt.executeQuery();
            if (rs.next())
            {
                return true;
            }
            
        } catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        return false;
    }
    
    public int ManToID(String Manufacturer) //toTest
    {
        String sql = "SELECT MANUFACTURER_ID FROM MANUFACTURER WHERE NAME=?";
        int ID = 0;
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1, Manufacturer);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next())
            {
                ID = rs.getInt("MANUFACTURER_ID");
            }
            
        } catch (SQLException ex) {
            //throw Exception
        }
        return ID;
    }
    
    public int newProdID()
    {
        int ID=0;
        List<Integer> listID = new ArrayList();
        String sql = "SELECT PRODUCT_ID FROM PRODUCT";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
        {
            while(rs.next())
            {
                listID.add(rs.getInt("PRODUCT_ID"));
            }
            
            ID=Collections.max(listID)+1;
            
        } catch (SQLException ex) {
            //throw exception
        }
        
        return ID;
    }
    
    public int OrdDescToNum(String desc) throws DAOException   //For DAO. Uses the product description then returns it's ID.
    {
        int Num=0;
        String sql ="SELECT PRODUCT_ID FROM PRODUCT WHERE DESCRIPTION=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1,desc);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                Num=rs.getInt("PRODUCT_ID");
            }
            
        }catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return Num;
    }

    public float shipPrice(int PID, int quantity) throws DAOException   //For DAO. Computes the total price for the order. 
    {
        float price=0;
        String sql = "SELECT PURCHASE_COST FROM PRODUCT WHERE PRODUCT_ID=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1,PID);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                price=rs.getFloat("PURCHASE_COST");
            }
            
        }catch (SQLException ex) {
            throw new DAOException("DataBase Connection Failed.");
        }
        
        return price*quantity;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Client DAO methods. Click on the + sign on the left to edit the code.">
    
    public void editCustomer(   int customerID, char discountCode, int ZIP, String Nom, String addr1, String addr2, String City, 
                                String state, String phone, String Fax, String email, int creditLimit)  //To test
    {
        String sql =    "UPDATE CUSTOMER "
                        + "SET discount_code=?, zip=?, name=?, adressline1=?, adresseline2=?, city=?, state=?, "
                        + "phone=?, fax=?, email=?, credit_limit=? "
                        + "where order_num=?";
        
        try(Connection connection =myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setObject(1, discountCode);
            stmt.setObject(2, ZIP);
            stmt.setObject(3, Nom);
            stmt.setObject(4, addr1);
            stmt.setObject(5, addr2);
            stmt.setObject(6, City);
            stmt.setObject(7, state);
            stmt.setObject(8, phone);
            stmt.setObject(9, Fax);
            stmt.setObject(10, email);
            stmt.setObject(11, creditLimit);
            stmt.setObject(12, customerID);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            //throw connection exception
        }
    }
    
    public int addOrder(int customerID, String product, int quantity, String fCompany) throws DAOException  //To test
    {
        String currentDate=dateFormat.format(date);
        
        List<Integer> ON = this.getAllOrderNumbers();
        int NewON = Collections.max(ON)+1;
        int prodID = this.OrdDescToNum(product);
        float price = this.shipPrice(prodID, quantity);
        
        String sql = "INSERT INTO PURCHASE_ORDER VALUES(?,?,?,?,?,?,?,?)";

        try (Connection connection = myDataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setObject(1, NewON);
            stmt.setObject(2, customerID);  
            stmt.setObject(3, prodID);  
            stmt.setObject(4, quantity);
            stmt.setObject(5, price);
            stmt.setObject(6, currentDate);
            stmt.setObject(7, currentDate);
            stmt.setObject(8, fCompany);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            //throws exception
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return NewON;
    }
    
    public void editOrder(int orderNumber, String product, int quantity) throws DAOException    //To test
    {
        int prodID = this.OrdDescToNum(product);
        String currentDate=dateFormat.format(date);
        String sql="UPDATE PURCHASE_ORDER SET PRODUCT_ID=?, QUANTITY=?, SALES_DATE=?, SHIPPING_DATE=? WHERE ORDER_NUM=?";
        
        try(Connection connection =myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1,prodID);
            stmt.setInt(2, quantity);
            stmt.setString(3, currentDate);
            stmt.setString(4, currentDate);
            stmt.setInt(5, orderNumber);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            //throw exception
        }
    }
    
    public void deleteOrder(int orderNumber)    //To test
    {
        String sql="DELETE FROM PURCHASE_ORDER WHERE ORDER_NUM=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1, orderNumber);
            stmt.executeUpdate();
            
        }catch (SQLException ex) {
            //throws exception
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Admin DAO methods. Click on the + sign on the left to edit the code.">
    
    public void createProduct(String Manufacturer, String ProductCode, float PurchaseCost, int Quantity, float markup, String Description)
    {
        String sql ="INSERT INTO PRODUCT VALUES(?,?,?,?,?,?,?,?)";
        int newID = this.newProdID();
        int manID = this.ManToID(Manufacturer);
        String available = "FALSE";
        if(Quantity!=0)
        {
            available="TRUE";
        }
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1, newID);
            stmt.setInt(2, manID);
            stmt.setString(3, ProductCode);
            stmt.setFloat(4, PurchaseCost);
            stmt.setInt(5, Quantity);
            stmt.setFloat(6, markup);
            stmt.setString(7, available);
            stmt.setString(8, Description);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            //throw exception
        }
    }
    
    public void deleteProduct(String Description)   //toTest
    {
        String sql = "DELETE FROM PRODUCT WHERE DESCRIPTION=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1, Description);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            //throw exception
        }
    }
    
    public void editProduct(String Manufacturer, String ProductCode, float PurchaseCost, int Quantity, float markup, String Description)    //toTest
    {
        String sql = "UPDATE PRODUCT "
                    + "SET MANUFACTURER_ID=?, PRODUCT_CODE=?, PURCHASE_COST=?, QUANTITY_ON_HAND=?, MARKUP=?, AVAILABLE=?"
                    + "WHERE DESCRIPTION=?";
        
        int manID = this.ManToID(Manufacturer);
        String available = "FALSE";
        if (Quantity!=0)
        {
            available="TRUE";
        }
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1, manID);
            stmt.setString(2, ProductCode);
            stmt.setFloat(3, PurchaseCost);
            stmt.setInt(4, Quantity);
            stmt.setFloat(5, markup);
            stmt.setString(6, available);
            stmt.setString(7, Description);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            //throw exception
        }
    }
    
    public ChiffreAff getChiffresAffairesClient(String clientName, String dateDeb, String dateFin) throws ParseException  //toTest
    {
        ChiffreAff cA = new ChiffreAff(clientName,0.f);
        Date deb = dateFormat.parse(dateDeb);
        Date fin = dateFormat.parse(dateFin);
        
        String sql = "SELECT PURCHASE_ORDER.SHIPPING_COST "
                    + "FROM CUSTOMER INNER JOIN PURCHASE_ORDER ON CUSTOMER.CUSTOMER_ID=PURCHASE_ORDER.CUSTOMER_ID"
                    + "WHERE CUSTOMER.NAME=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1, clientName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                cA.addToSales(rs.getFloat("SHIPPING_COST"));
            }
            
        } catch (SQLException ex)
        {
            //Throw Exception.
        }
        
        return cA;
    }
    
    public ChiffreAff getChiffresAffairesProduit(String produit, String dateDeb, String dateFin) throws DAOException, ParseException   //toTest
    {
        ChiffreAff cA = new ChiffreAff(produit,0.f);
        int PID = OrdDescToNum(produit);
        Date deb = dateFormat.parse(dateDeb);
        Date fin = dateFormat.parse(dateFin);
        
        String sql = "SELECT SHIPPING_COST FROM PURCHASE_ORDER WHERE PRODUCT_ID=? AND SALES_DATE>=? AND SHIPPING_DATE<=?;";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setInt(1, PID);
            stmt.setDate(2, (java.sql.Date) deb);
            stmt.setDate(3, (java.sql.Date) fin);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next())
            {
                float num = rs.getFloat("SHIPPING_COST");
                cA.addToSales(num); 
            }
            
        } catch (SQLException ex){
            //Throw exception
        }
        return cA;
    }
    
    public ChiffreAff getChiffresAffairesState(String state, String dateDeb, String dateFin) throws ParseException  //toTest
    {
        ChiffreAff cA = new ChiffreAff(state,0.f);
        Date deb = dateFormat.parse(dateDeb);
        Date fin = dateFormat.parse(dateFin);
        
        String sql= "SELECT PURCHASE_ORDER.SHIPPING_COST "
                    + "FROM CUSTOMER INNER JOIN PURCHASE_ORDER ON CUSTOMER.CUSTOMER_ID=PURCHASE_ORDER.CUSTOMER_ID"
                    + "WHERE CUSTOMER.STATE=?";
        
        try(Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1, state);
            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                cA.addToSales(rs.getFloat("SHIPPING_COST"));
            }
            
        } catch (SQLException ex)
        {
            //Throw Exception.
        }
        
        return cA;
    }
    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Other Test methods. Click on the + sign on the left to edit the code.">
    
    public String showDate()    //Gets current date.
    {
        return dateFormat.format(date);
    }
    
    // </editor-fold>
}
