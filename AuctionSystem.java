package dbms_mini_project_462;

import java.sql.*;
import java.util.Scanner;
public class AuctionSystem {
    // Method to get the database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/454_db_assign2", "root", "Rajiv@1974");
    }
    // Insert Methods
    public static void insertUser(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter UserID: ");
        String userID = scanner.nextLine();
        System.out.println("Enter UserName: ");
        String userName = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        System.out.println("Enter Phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter Address: ");
        String address = scanner.nextLine();
        System.out.println("Enter Role: ");
        String role = scanner.nextLine();
        String query = "INSERT INTO user (userID, userName, password, email, phone, address, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, userID);
            stmt.setString(2, userName);
            stmt.setString(3, password);
            stmt.setString(4, email);
            stmt.setString(5, phone);
            stmt.setString(6, address);
            stmt.setString(7, role);
            stmt.executeUpdate();
            System.out.println("User added successfully.");
        }
    }

    public static void insertProduct(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ItemID: ");
        int itemID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Item Name: ");
        String itemName = scanner.nextLine();

        System.out.println("Enter Description: ");
        String description = scanner.nextLine();
        System.out.println("Enter Starting Price: ");
        double startingPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter SellerID: ");
        String sellerID = scanner.nextLine();
        System.out.println("Enter Auction Start Time (yyyy-MM-dd HH:mm:ss): ");
        String auctionStart = scanner.nextLine();
        System.out.println("Enter Auction End Time (yyyy-MM-dd HH:mm:ss): ");
        String auctionEnd = scanner.nextLine();

        String query = "INSERT INTO product (itemID, itemName, description, startingPrice, sellerID, auctionStart, auctionEnd) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, itemID);
            stmt.setString(2, itemName);
            stmt.setString(3, description);
            stmt.setDouble(4, startingPrice);
            stmt.setString(5, sellerID);
            stmt.setString(6, auctionStart);
            stmt.setString(7, auctionEnd);
            stmt.executeUpdate();
            System.out.println("Product added successfully.");
        }
    }

    public static void insertBid(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter BidID: ");
        String bidID = scanner.nextLine();
        System.out.println("Enter ItemID: ");
        int itemID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter BidderID: ");
        String bidderID = scanner.nextLine();
        System.out.println("Enter Bid Amount: ");
        double bidAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Bid Time (yyyy-MM-dd HH:mm:ss): ");
        String bidTime = scanner.nextLine();

        String query = "INSERT INTO bid (bidID, itemID, bidderID, bidAmount, bidTime) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, bidID);
            stmt.setInt(2, itemID);
            stmt.setString(3, bidderID);
            stmt.setDouble(4, bidAmount);
            stmt.setString(5, bidTime);
            stmt.executeUpdate();
            System.out.println("Bid added successfully.");
        }
    }

    public static void insertPastRecord(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter RecordID: ");
        String recordID = scanner.nextLine();
        System.out.println("Enter AuctionID: ");
        String auctionID = scanner.nextLine();
        System.out.println("Enter ItemID: ");
        int itemID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Winning Bid: ");
        double winningBid = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Winner UserID: ");
        String winnerUserID = scanner.nextLine();
        System.out.println("Enter End Price: ");
        double endPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Start Time (yyyy-MM-dd HH:mm:ss): ");
        String startTime = scanner.nextLine();
        System.out.println("Enter End Time (yyyy-MM-dd HH:mm:ss): ");
        String endTime = scanner.nextLine();
        System.out.println("Enter Bid Count: ");
        int bidCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter Status: ");
        String status = scanner.nextLine();

        String query = "INSERT INTO pastRecords (recordID, auctionID, itemID, winning_bid, winner_userID, end_price, start_time, end_time, bid_count, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, recordID);
            stmt.setString(2, auctionID);
            stmt.setInt(3, itemID);
            stmt.setDouble(4, winningBid);
            stmt.setString(5, winnerUserID);
            stmt.setDouble(6, endPrice);
            stmt.setString(7, startTime);
            stmt.setString(8, endTime);
            stmt.setInt(9, bidCount);
            stmt.setString(10, status);
            stmt.executeUpdate();
            System.out.println("Past record added successfully.");
        }
    }
    
    // Update Methods
   public static void updateUser(Connection connection) throws SQLException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter UserID to update: ");
    String userID = scanner.nextLine();
    System.out.println("Enter new UserName: ");
    String userName = scanner.nextLine();
    System.out.println("Enter new Password: ");
    String password = scanner.nextLine();
    System.out.println("Enter new Email: ");
    String email = scanner.nextLine();
    System.out.println("Enter new Phone: ");
    String phone = scanner.nextLine();
    System.out.println("Enter new Address: ");
    String address = scanner.nextLine();
    System.out.println("Enter new Role: ");
    String role = scanner.nextLine();
    String query = "UPDATE user SET userName=?, password=?, email=?,phone=?, address=?, role=? WHERE userID=?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
    stmt.setString(1, userName);
    stmt.setString(2, password);
    stmt.setString(3, email);
    stmt.setString(4, phone);
    stmt.setString(5, address);
    stmt.setString(6, role);
    stmt.setString(7, userID);
    stmt.executeUpdate();
    System.out.println("User updated successfully.");
    }
    }
    public static void updateProduct(Connection connection) throws SQLException
    {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter ItemID to update: ");
    int itemID = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    System.out.println("Enter new Item Name: ");
    String itemName = scanner.nextLine();
    System.out.println("Enter new Description: ");
    String description = scanner.nextLine();
    System.out.println("Enter new Starting Price: ");
    double startingPrice = scanner.nextDouble();
    scanner.nextLine(); // Consume newline
    System.out.println("Enter new SellerID: ");
    String sellerID = scanner.nextLine();
    System.out.println("Enter new Auction Start Time (yyyy-MM-dd HH:mm:ss):");
    String auctionStart = scanner.nextLine();
   System.out.println("Enter new Auction End Time (yyyy-MM-dd HH:mm:ss):");
    String auctionEnd = scanner.nextLine();
    String query = "UPDATE product SET itemName=?, description=?,startingPrice=?, sellerID=?, auctionStart=?, auctionEnd=? WHERE itemID=?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
    stmt.setString(1, itemName);
    stmt.setString(2, description);
    stmt.setDouble(3, startingPrice);
    stmt.setString(4, sellerID);
    stmt.setString(5, auctionStart);
    stmt.setString(6, auctionEnd);
    stmt.setInt(7, itemID);
    stmt.executeUpdate();
    System.out.println("Product updated successfully.");
    }
    }
    public static void updateBid(Connection connection) throws SQLException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter BidID to update: ");
    String bidID = scanner.nextLine();
    System.out.println("Enter new Bid Amount: ");
    double bidAmount = scanner.nextDouble();
    scanner.nextLine(); // Consume newline
    System.out.println("Enter new Bid Time (yyyy-MM-dd HH:mm:ss): ");
    String bidTime = scanner.nextLine();
    String query = "UPDATE bid SET bidAmount=?, bidTime=? WHERE bidID=?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
    stmt.setDouble(1, bidAmount);
    stmt.setString(2, bidTime);
    stmt.setString(3, bidID);
    stmt.executeUpdate();
    System.out.println("Bid updated successfully.");
    }
    }
    public static void updatePastRecord(Connection connection) throws
    SQLException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter RecordID to update: ");
    String recordID = scanner.nextLine();
    System.out.println("Enter new AuctionID: ");
    String auctionID = scanner.nextLine();
    System.out.println("Enter new Winning Bid: ");
    double winningBid = scanner.nextDouble();
    scanner.nextLine(); // Consume newline
    System.out.println("Enter new Winner UserID: ");
    String winnerUserID = scanner.nextLine();
    System.out.println("Enter new End Price: ");
    double endPrice = scanner.nextDouble();
   scanner.nextLine(); // Consume newline
    System.out.println("Enter new Status: ");
    String status = scanner.nextLine();
    String query = "UPDATE pastRecords SET auctionID=?, winning_bid=?,winner_userID=?, end_price=?, status=? WHERE recordID=?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
    stmt.setString(1, auctionID);
    stmt.setDouble(2, winningBid);
    stmt.setString(3, winnerUserID);
    stmt.setDouble(4, endPrice);
    stmt.setString(5, status);
    stmt.setString(6, recordID);
    stmt.executeUpdate();
    System.out.println("Past record updated successfully.");
    }
    }
    // Delete Methods
    public static void deleteUser(Connection connection) throws SQLException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter UserID to delete: ");
    String userID = scanner.nextLine();
    String query = "DELETE FROM user WHERE userID=?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
    stmt.setString(1, userID);
    stmt.executeUpdate();
    System.out.println("User deleted successfully.");
    }
    }
    public static void deleteProduct(Connection connection) throws SQLException
    {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter ItemID to delete: ");
    int itemID = scanner.nextInt();
    String query = "DELETE FROM product WHERE itemID=?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
    stmt.setInt(1, itemID);
    stmt.executeUpdate();
    System.out.println("Product deleted successfully.");
    }
    }
    public static void deleteBid(Connection connection) throws SQLException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter BidID to delete: ");
    String bidID = scanner.nextLine();
    String query = "DELETE FROM bid WHERE bidID=?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
   stmt.setString(1, bidID);
    stmt.executeUpdate();
    System.out.println("Bid deleted successfully.");
    }
    }
    public static void deletePastRecord(Connection connection) throws
    SQLException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter RecordID to delete: ");
    String recordID = scanner.nextLine();
    String query = "DELETE FROM pastRecords WHERE recordID=?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
    stmt.setString(1, recordID);
    stmt.executeUpdate();
    System.out.println("Past record deleted successfully.");
    }
    }
    public static void displayUsers(Connection connection) throws SQLException {
    String query = "SELECT * FROM user";
    try (Statement stmt = connection.createStatement(); ResultSet rs =
    stmt.executeQuery(query)) {
    while (rs.next()) {
    System.out.println("UserID: " + rs.getString("userID"));
    System.out.println("UserName: " + rs.getString("userName"));
    System.out.println("Email: " + rs.getString("email"));
    System.out.println("Phone: " + rs.getString("phone"));
    System.out.println("Role: " + rs.getString("role"));
    System.out.println("----------");
    }
    }
    }
    public static void displayProducts(Connection connection) throws
    SQLException {
    String query = "SELECT * FROM product";
    try (Statement stmt = connection.createStatement(); ResultSet rs =
    stmt.executeQuery(query)) {
    while (rs.next()) {
    System.out.println("ItemID: " + rs.getInt("itemID"));
    System.out.println("Item Name: " + rs.getString("itemName"));
    System.out.println("Description: " +
    rs.getString("description"));
    System.out.println("Starting Price: " +
    rs.getDouble("startingPrice"));
    System.out.println("SellerID: " + rs.getString("sellerID"));
    System.out.println("Auction Start: " +
    rs.getString("auctionStart"));
   System.out.println("Auction End: " +
    rs.getString("auctionEnd"));
    System.out.println("----------");
    }
    }
    }
    public static void displayBids(Connection connection) throws SQLException {
    String query = "SELECT * FROM bid";
    try (Statement stmt = connection.createStatement(); ResultSet rs =
    stmt.executeQuery(query)) {
    while (rs.next()) {
    System.out.println("BidID: " + rs.getString("bidID"));
    System.out.println("ItemID: " + rs.getInt("itemID"));
    System.out.println("BidderID: " + rs.getString("bidderID"));
    System.out.println("Bid Amount: " + rs.getDouble("bidAmount"));
    System.out.println("Bid Time: " + rs.getString("bidTime"));
    System.out.println("----------");
    }
    }
    }
    public static void displayPastRecords(Connection connection) throws
    SQLException {
    String query = "SELECT * FROM pastRecords";
    try (Statement stmt = connection.createStatement(); ResultSet rs =
    stmt.executeQuery(query)) {
    while (rs.next()) {
    System.out.println("RecordID: " + rs.getString("recordID"));
    System.out.println("AuctionID: " + rs.getString("auctionID"));
    System.out.println("ItemID: " + rs.getInt("itemID"));
    System.out.println("Winning Bid: " +
    rs.getDouble("winning_bid"));
    System.out.println("Winner UserID: " +
    rs.getString("winner_userID"));
    System.out.println("End Price: " + rs.getDouble("end_price"));
    System.out.println("Start Time: " + rs.getString("start_time"));
    System.out.println("End Time: " + rs.getString("end_time"));
    System.out.println("Bid Count: " + rs.getInt("bid_count"));
    System.out.println("Status: " + rs.getString("status"));
    System.out.println("----------");
    }
    }
    }
    public static void insertShipping(Connection connection) throws SQLException
    {
    Scanner scanner = new Scanner(System.in);
    // Collect data from the user
    System.out.println("Enter ShippingID: ");
    int shippingID = scanner.nextInt();
   System.out.println("Enter ItemID: ");
    int itemID = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    System.out.println("Enter BuyerID: ");
    String buyerID = scanner.nextLine();
    System.out.println("Enter Shipping Address: ");
    String shippingAddress = scanner.nextLine();
    System.out.println("Enter Shipping Date (yyyy-MM-dd HH:mm:ss): ");
    String shippingDate = scanner.nextLine();
    System.out.println("Enter Delivery Date (yyyy-MM-dd HH:mm:ss): ");
    String deliveryDate = scanner.nextLine();
    System.out.println("Enter Shipping Status: ");
    String status = scanner.nextLine();
    System.out.println("Enter Tracking Number: ");
    String trackingNumber = scanner.nextLine();
    String query = "INSERT INTO shipping (shippingID, itemID, buyerID,shippingAddress, shippingDate, deliveryDate, status, trackingNumber) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
    stmt.setInt(1, shippingID);
    stmt.setInt(2, itemID);
    stmt.setString(3, buyerID);
    stmt.setString(4, shippingAddress);
    stmt.setString(5, shippingDate);
    stmt.setString(6, deliveryDate);
    stmt.setString(7, status);
    stmt.setString(8, trackingNumber);
    stmt.executeUpdate();
    System.out.println("Shipping record inserted successfully.");
    }
    }
    // Update a shipping record
    public static void updateShipping(Connection connection) throws SQLException
    {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter ShippingID to update: ");
    int shippingID = scanner.nextInt();
    scanner.nextLine(); // Consume newline character
    System.out.println("Enter new Shipping Address: ");
    String shippingAddress = scanner.nextLine();
    System.out.println("Enter new Shipping Status: ");
    String status = scanner.nextLine();
    System.out.println("Enter new Tracking Number: ");
    String trackingNumber = scanner.nextLine();
    String query = "UPDATE shipping SET shippingAddress = ?, status = ?,trackingNumber = ? WHERE shippingID = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
    stmt.setString(1, shippingAddress);
    stmt.setString(2, status);
   stmt.setString(3, trackingNumber);
    stmt.setInt(4, shippingID);
    stmt.executeUpdate();
    System.out.println("Shipping record updated successfully.");
    }
    }
    // Delete a shipping record
    public static void deleteShipping(Connection connection) throws SQLException
    {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter ShippingID to delete: ");
    int shippingID = scanner.nextInt();
    String query = "DELETE FROM shipping WHERE shippingID = ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
    stmt.setInt(1, shippingID);
    stmt.executeUpdate();
    System.out.println("Shipping record deleted successfully.");
    }
    }
    // Display all shipping records
    public static void displayShipping(Connection connection) throws
    SQLException {
    String query = "SELECT * FROM shipping";
    try (Statement stmt = connection.createStatement(); ResultSet rs =
    stmt.executeQuery(query)) {
    while (rs.next()) {
    System.out.println("ShippingID: " + rs.getInt("shippingID"));
    System.out.println("ItemID: " + rs.getInt("itemID"));
    System.out.println("BuyerID: " + rs.getString("buyerID"));
    System.out.println("Shipping Address: " +
    rs.getString("shippingAddress"));
    System.out.println("Shipping Date: " +
    rs.getString("shippingDate"));
    System.out.println("Delivery Date: " +
    rs.getString("deliveryDate"));
    System.out.println("Status: " + rs.getString("status"));
    System.out.println("Tracking Number: " +
    rs.getString("trackingNumber"));
    System.out.println("----------");
    }
    }
    }
     
    private static final Object lock = new Object();
    // Method to handle multithreading for two users
    public static void startMultiThreading(final Connection connection) {
        Runnable task1 = new Runnable() {
            public void run() {
                synchronized(lock){
                try {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("1. Insert");
                    System.out.println("2. Display");
                    System.out.println("3. Update");
                    System.out.println("4. Delete");
                    System.out.println("5. Exit");
                    System.out.println("User 1: Choose an option:");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Switch cases for User 1's actions
                    switch (choice) {
                        case 1:
                            System.out.println("User 1: Choose entity to insert:");
                            System.out.println("1. User");
                            System.out.println("2. Product");
                            System.out.println("3. Bid");
                            System.out.println("4. Past Record");
                            int insertChoice = scanner.nextInt();
                            if (insertChoice == 1) {
                                insertUser(connection);
                            } else if (insertChoice == 2) {
                                insertProduct(connection);
                            } else if (insertChoice == 3) {
                                insertBid(connection);
                            } else if (insertChoice == 4) {
                                insertPastRecord(connection);
                            }
                            break;
                        case 2:
                        	 System.out.println("User 1: Choose entity to Display:");
                        	 System.out.println("1. User");
                        	 System.out.println("2. Product");
                        	 System.out.println("3. Bid");
                        	 System.out.println("4. Shipping");
                        	 System.out.println("5. Past Record");
                        	 int displayChoice = scanner.nextInt();
                        	 scanner.nextLine(); // Consume newline
                        	 if (displayChoice == 1) {
                        	 displayUsers(connection);
                        	 } else if (displayChoice == 2) {
                        	 displayProducts(connection);
                        	 } else if (displayChoice == 3) {
                        	 displayBids(connection);
                        	 } else if (displayChoice == 4) {
                        	 displayShipping(connection);
                        	 }
                        	 else if (displayChoice == 5) {
                        		 displayPastRecords(connection);
                        		 }

                        	break;
                        case 3:
                        	System.out.println("User 1: Choose entity to update:");
                        	 System.out.println("1. User");
                        	 System.out.println("2. Product");
                        	 System.out.println("3. Bid");
                        	 System.out.println("4.Shipping");
                        	 System.out.println("5. Past Record");
                        	 int updateChoice = scanner.nextInt();
                        	 scanner.nextLine(); // Consume newline
                        	 if (updateChoice == 1) {
                        	 updateUser(connection);
                        	 } else if (updateChoice == 2) {
                        	 updateProduct(connection);
                        	 } else if (updateChoice == 3) {
                        	 updateBid(connection);
                        	 } else if (updateChoice == 4) {
                        	 updateShipping(connection);
                        	 }else if (updateChoice == 5) {
                        	 updatePastRecord(connection);
                        	 }
                            break;
                        case 4:
                        	 System.out.println("User 1: Choose entity to delete:");
                        	 System.out.println("1. User");
                        	 System.out.println("2. Product");
                        	 System.out.println("3. Bid");
                        	 System.out.println("4.Shipping");
                        	 System.out.println("5. Past Record");
                        	 int deleteChoice = scanner.nextInt();
                        	 scanner.nextLine(); // Consume newline
                        	 if (deleteChoice == 1) {
                        	 deleteUser(connection);
                        	 } else if (deleteChoice == 2) {
                        	 deleteProduct(connection);
                        	 } else if (deleteChoice == 3) {
                        	 deleteBid(connection);
                        	 }
                        	 else if (deleteChoice == 4) {
                        	 deleteShipping(connection);
                        	 }
                        	 else if (deleteChoice == 5) {
                        	 deletePastRecord(connection);
                        	 }
                            break;
                        case 5:
                            System.out.println("Exiting User 1.");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            }
        };

        Runnable task2 = new Runnable() {
            public void run() {
                synchronized(lock){
                try {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("User 2: Choose an option:");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Switch cases for User 2's actions
                    switch (choice) {
                        case 1:
                            System.out.println("User 2: Choose entity to insert:");
                            System.out.println("1. User");
                            System.out.println("2. Product");
                            System.out.println("3. Bid");
                            System.out.println("4. Past Record");
                            int insertChoice = scanner.nextInt();
                            if (insertChoice == 1) {
                                insertUser(connection);
                            } else if (insertChoice == 2) {
                                insertProduct(connection);
                            } else if (insertChoice == 3) {
                                insertBid(connection);
                            } else if (insertChoice == 4) {
                                insertPastRecord(connection);
                            }
                            break;
                        case 2:
                        	System.out.println("User 2: Choose entity to Display:");
                        	 System.out.println("1. User");
                        	 System.out.println("2. Product");
                        	 System.out.println("3. Bid");
                        	 System.out.println("4. Shipping");
                        	 System.out.println("5. Past Record");
                        	 int displayChoice = scanner.nextInt();
                        	 scanner.nextLine(); // Consume newline
                        	 if (displayChoice == 1) {
                        	 displayUsers(connection);
                        	 } else if (displayChoice == 2) {
                        	 displayProducts(connection);
                        	 } else if (displayChoice == 3) {
                        	 displayBids(connection);
                        	 } else if (displayChoice == 4) {
                        	 displayShipping(connection);
                        	 }
                        	 else if (displayChoice == 5) {
                        		 displayPastRecords(connection);
                        		 }
                            break;
                        case 3:
                        	System.out.println("User 2: Choose entity to update:");
                       	 System.out.println("1. User");
                       	 System.out.println("2. Product");
                       	 System.out.println("3. Bid");
                       	 System.out.println("4. Shipping");
                       	 System.out.println("5. Past Record");
                       	 int updateChoice = scanner.nextInt();
                       	 scanner.nextLine(); // Consume newline
                       	 if (updateChoice == 1) {
                       	 updateUser(connection);
                       	 } else if (updateChoice == 2) {
                       	 updateProduct(connection);
                       	 } else if (updateChoice == 3) {
                       	 updateBid(connection);
                       	 } else if (updateChoice == 4) {
                       	 updateShipping(connection);
                       	 }else if (updateChoice == 5) {
                       	 updatePastRecord(connection);
                       	 }
                            break;
                        case 4:
                        	System.out.println("User 2: Choose entity to delete:");
                       	 System.out.println("1. User");
                       	 System.out.println("2. Product");
                       	 System.out.println("3. Bid");
                       	 System.out.println("4. Shipping");
                       	 System.out.println("5. Past Record");
                       	 int deleteChoice = scanner.nextInt();
                       	 scanner.nextLine(); // Consume newline
                       	 if (deleteChoice == 1) {
                       	 deleteUser(connection);
                       	 } else if (deleteChoice == 2) {
                       	 deleteProduct(connection);
                       	 } else if (deleteChoice == 3) {
                       	 deleteBid(connection);
                       	 }
                       	 else if (deleteChoice == 4) {
                       	 deleteShipping(connection);
                       	 }
                       	 else if (deleteChoice == 5) {
                       	 deletePastRecord(connection);
                       	 }
                            break;
                        case 5:
                            System.out.println("Exiting User 2.");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            }
        };

        // Create two threads for User 1 and User 2
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Start both threads
        thread1.start();
        thread2.start();
        try {
            // Wait for both threads to finish
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            // Establish connection to the database
            Connection connection = getConnection();

            // Start the multi-threaded interaction for two users
            startMultiThreading(connection);
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}

/*module mini_project {
	requires java.sql;
	requires java.desktop;
}*/