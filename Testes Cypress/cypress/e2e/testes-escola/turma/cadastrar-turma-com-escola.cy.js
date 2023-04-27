describe("Cadastrar turma com ID da escola", () => {
    it("Cadastrar turma com ID da escola", () => {
        cy.request("POST", "http://localhost:8085/turma", { nome: "Turma A", escola: { id: 2 } }).as("CadastrarTurmaComEscola");
        cy.get("@CadastrarTurmaComEscola").then(response => {
            expect(response.body).to.have.property("escola");
        })
    })
})