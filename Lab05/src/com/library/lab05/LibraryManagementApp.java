package com.library.lab05;

public class LibraryManagementApp {
    public static void main(String[] args) {

        System.out.println("\n" + "=".repeat(70));
        System.out.println("    DESIGN PATTERNS: SINGLETON & STRATEGY");
        System.out.println("=".repeat(70));


        System.out.println("\n[STEP 1] Initializing LibrarySystem (Singleton Pattern):");
        LibrarySystem librarySystem = LibrarySystem.getInstance();


        System.out.println("Getting LibrarySystem instance again:");
        LibrarySystem sameInstance = LibrarySystem.getInstance();
        System.out.println("    ✅ Same instance? " + (librarySystem == sameInstance));
        
        System.out.println("\n[STEP 2] Creating Library Items:");

        PhysicalBook book1 = new PhysicalBook("Java Programming", "John Smith", "978-0134685991", 450.0, "A1-04");
        PhysicalBook book2 = new PhysicalBook("Clean Code", "Robert Martin", "978-0132350884", 520.0, "B2-15");
        PhysicalBook book3 = new PhysicalBook("Design Patterns", "Gang of Four", "978-0201633612", 680.0, "A3-22");
        PhysicalBook book4 = new PhysicalBook("The Art of War", "Sun Tzu", "978-1599869773", 250.0, "C1-10");
        PhysicalBook book5 = new PhysicalBook("Refactoring", "Martin Fowler", "978-0134757599", 550.0, "A2-08");

        librarySystem.addItem(book1);
        librarySystem.addItem(book2);
        librarySystem.addItem(book3);
        librarySystem.addItem(book4);
        librarySystem.addItem(book5);

        // Add E-Books
        EBook ebook1 = new EBook("Effective Java", "Joshua Bloch", "978-0134685991",
                "https://library.ebooks.com/effective-java.pdf", 5.2);
        EBook ebook2 = new EBook("Python Crash Course", "Eric Matthes", "978-1593279288",
                "https://library.ebooks.com/python-crash.pdf", 8.7);

        librarySystem.addItem(ebook1);
        librarySystem.addItem(ebook2);


        System.out.println("\n" + "=".repeat(70));
        System.out.println("    [STEP 3] STRATEGY PATTERN: Creating Members with Different Strategies");
        System.out.println("=".repeat(70));

        System.out.println("\n✨ KEY CONCEPT: Each member has a MembershipStrategy!");
        System.out.println("    Strategy determines: borrow limit, loan period, late fee discount\n");

     
        Member basicMember = new Member("M001", "Somsak", new BasicMembershipStrategy());
        Member studentMember = new Member("M002", "Suda", new StudentMembershipStrategy());
        Member premiumMember = new Member("M003", "Somchai", new PremiumMembershipStrategy());

        librarySystem.addMember(basicMember);
        librarySystem.addMember(studentMember);
        librarySystem.addMember(premiumMember);

        System.out.println("--- MEMBER INFORMATION ---");
        for (Member member : librarySystem.getAllMembers()) {
            member.displayMemberInfo();
        }

        System.out.println("\n" + "=".repeat(70));
        System.out.println("    [STEP 4] STRATEGY PATTERN: Testing Different Borrow Behaviors");
        System.out.println("=".repeat(70));

        System.out.println("\n✨ Each member type has different borrow limits and loan periods!\n");

        // Basic Member borrows (limit: 1, period: 14 days)
        System.out.println("--- Basic Member (Somsak) Borrows ---");
        book1.checkOut(basicMember);

        // Student Member borrows (limit: 5, period: 21 days)
        System.out.println("\n--- Student Member (Suda) Borrows ---");
        book2.checkOut(studentMember);

        // Premium Member borrows (unlimited, period: 30 days)
        System.out.println("\n--- Premium Member (Somchai) Borrows ---");
        book3.checkOut(premiumMember);
        ebook1.checkOut(premiumMember);
        ebook2.checkOut(premiumMember); // Premium can borrow unlimited!

        // ==================== STRATEGY PATTERN: LATE FEE COMPARISON
        // ====================
        System.out.println("\n" + "=".repeat(70));
        System.out.println("    [STEP 5] STRATEGY PATTERN: Late Fee Discounts");
        System.out.println("=".repeat(70));

        System.out.println("\n✨ Different membership types get different late fee discounts!\n");

        double baseFee = 100.0;
        System.out.println("Base Late Fee: " + baseFee + " Baht\n");

        System.out.println("1️⃣  Basic Member (No discount):");
        double basicFee = basicMember.calculateLateFee(baseFee);
        System.out.println("    Final: " + basicFee + " Baht\n");

        System.out.println("2️⃣  Student Member (20% discount):");
        double studentFee = studentMember.calculateLateFee(baseFee);
        System.out.println("    Final: " + studentFee + " Baht\n");

        System.out.println("3️⃣  Premium Member (100% FREE!):");
        double premiumFee = premiumMember.calculateLateFee(baseFee);
        System.out.println("    Final: " + premiumFee + " Baht\n");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("    [STEP 5] STRATEGY PATTERN: Changing Strategy at Runtime");
        System.out.println("=".repeat(70));

        System.out.println("\n✨ KEY CONCEPT: Members can upgrade/downgrade membership dynamically!\n");

    
        System.out.println("--- Somsak (MemberID:M001) Upgrades from Basic to Premium ---");
        Member somsak = librarySystem.findMemberById("M001");
        
        System.out.println("\n--- Before Upgrade: Somsak can only borrow 1 item ---");
        book5.checkOut(basicMember); 

        somsak.setMembershipStrategy(new PremiumMembershipStrategy());
        somsak.displayMemberInfo();

        System.out.println("\n--- After Upgrade: Somsak can now borrow more! ---");
        book5.checkOut(basicMember); 

        librarySystem.displayStatistics();
    }
}
